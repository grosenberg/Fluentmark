<template>
  <div class="mark">
    <span ref="jax" v-html="html" />
  </div>
</template>

<script setup lang="ts">
  import { computed, onMounted, nextTick, ref } from 'vue';
  import { useAppStore } from '@/store/app';
  import { useSocketStore } from '@/store/socket';
  import { initMathJax, renderMathJax, clearMathJax } from '@/plugins/mathjax';
  import { scrollTo } from '@/plugins/scrollTo';

  const props = defineProps({
    mathjax: { type: Boolean, default: true },
  });

  const store = useAppStore();
  const wsStore = useSocketStore();
  const jax = ref<HTMLElement | null>(null);

  // backend prepared HTML for display
  const html = computed(() => {
    const raw = wsStore.envl.msg.content;
    console.log('Loading content: "%s"', raw.length > 24 ? raw.substring(0, 19) + ' ...' : raw);

    const line = wsStore.envl.msg.line;
    const total = wsStore.envl.msg.total;

    nextTick(() => {
      if (props.mathjax && raw.length > 0 && jax.value) {
        console.log('Rendering MathJax.');
        renderMathJax(jax.value);
        if (line > -1 && store.linkScroll) {
          scrollTo(line, total);
        }
      }
    });

    return raw;
  });

  onMounted(() => {
    if (props.mathjax) initMathJax();
    console.log('LiveArea onMounted...');
    wsStore.refresh();
  });
</script>

<style scoped lang="scss">
  @import '@/styles/github.scss';
</style>
