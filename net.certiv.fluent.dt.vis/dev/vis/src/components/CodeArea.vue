<template>
  <v-card id="area" class="CodeDisplayer" rounded="lg">
    <PrismEditor class="ca-editor" v-model="contentModel" :highlight="highlighter" line-numbers readonly />
  </v-card>
</template>

<script setup lang="ts">
  import { onMounted, computed, ref } from 'vue';
  import { useSocketStore } from '@/store/socket';

  import prism from 'prismjs';
  import { PrismEditor } from 'vue-prism-editor';
  import 'vue-prism-editor/dist/prismeditor.min.css';
  import 'prismjs/themes/prism-tomorrow.css';

  import hljsCommon from 'highlight.js/lib/common';
  import beautify from 'js-beautify';

  const wsStore = useSocketStore();

  const props = defineProps({
    lang: { type: String, required: true },
    format: { type: Boolean, default: true },
  });

  const lang = ref(props.lang);

  onMounted(() => {
    console.log('Mounted CodeArea: %s.', lang.value);
  });

  const contentModel = computed({
    get() {
      const code = wsStore.envl.msg.content;
      console.log('Fetching code "%s"', code.length > 24 ? code.substring(0, 19) + ' ...' : code);
      detect(code);
      return format(code);
    },
    set(newValue) {
      console.log('Setting code "%s"', newValue.length > 24 ? newValue.substring(0, 19) + ' ...' : newValue);
    },
  });

  const highlighter = (code: string) => {
    return prism.highlight(code, prism.languages[lang.value], lang.value);
  };

  function detect(code: string) {
    if (props.lang === 'autodetect') {
      const result = hljsCommon.highlightAuto(escape(code));
      lang.value = result.language as string;
    }
    console.log('Language detect: %s -> %s', props.lang, lang.value);
  }

  function format(code: string) {
    if (!props.format) return code;

    console.log('Formatting "%s".', lang.value);
    switch (lang.value) {
      case 'js':
      case 'ts':
      case 'javascript':
      case 'typescript':
        return beautify(code);

      case 'dot':
      case 'html':
      case 'svg':
      case 'xml':
        return beautify.html(code, { indent_size: 2 });

      case 'css':
        return beautify.css(code);

      case 'json':
        return JSON.stringify(code, null, 2);

      default:
        return code;
    }
  }

  function escape(code: string): string {
    return code
      .replace(/&/g, '&amp;')
      .replace(/</g, '&lt;')
      .replace(/>/g, '&gt;')
      .replace(/"/g, '&quot;')
      .replace(/'/g, '&#x27;');
  }
</script>

<style scoped lang="scss">
  .ca-editor {
    background: rgb(var(--v-theme-background)); // #2d2d2d; // required
    color: rgb(var(--v-theme-content)); // #ccc;

    /* required: font-family font-size line-height */
    font-family: Fira Code, Fira Mono, Consolas, Menlo, Courier, monospace;
    font-size: 14px;
    line-height: 1.5;
    padding: 5px;
  }

  /* removes the editor outline */
  :deep(.prism-editor__textarea):focus {
    outline: none;
  }

  // background: #fafafa; // whitish bg
  // max-height: 400px; // vertical height limit?

  // .prism-editor__editor {
  //   white-space: pre !important;
  // }
  // .prism-editor__container {
  //   overflow-x: scroll !important;
  //   padding-bottom: 4px;
  //   // @include Scrollbar(14px, 8px);
  // }

  // // =================================================================================
  // // for line highlight

  // // $highlight-color-border: gray;
  // // $highlight-color: rgba(128, 128, 128, 0.384);

  // // $highlight-color-border: #42b983;
  // // $highlight-color: rgba(66, 185, 131, 0.165);

  // $highlight-color-border: #4e75a2;
  // $highlight-color: rgba(1, 115, 254, 0.22);

  // .prism-editor-wrapper {
  //   overflow: hidden;
  // }

  // .prism-editor__line-numbers {
  //   overflow: visible;
  // }

  // .prism-editor__line-number {
  //   border-left: 5px solid transparent;
  //   padding-left: 10px;
  //   position: relative;

  //   &.highlight-line {
  //     border-left: 5px solid $highlight-color-border;
  //     background: $highlight-color;
  //   }

  //   &.highlight-line:after {
  //     content: '';
  //     height: 21px;
  //     background: $highlight-color;
  //     pointer-events: none;
  //     position: absolute;
  //     z-index: 1;
  //     width: 100vw;
  //   }
  // }
</style>
