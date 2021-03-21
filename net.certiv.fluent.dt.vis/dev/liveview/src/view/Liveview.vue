<template>
	<div class="p-grid liveview">
		<div class="p-col-12">
			<div class="card lv-toolbar">

				<Toolbar>
					<template v-slot:left>
						<strong>{{filename}}</strong>
					</template>

					<template v-slot:right>
						<Dropdown v-model="themeChoice" :options="themeList" optionLabel="name" placeholder="Select a style" />
						<i class="pi p-toolbar-separator" />
						<Button label="Refresh" icon="pi pi-plus" @click="refresh" />
						<Button label="Clear" icon="pi pi-times" class="p-button-secondary" @click="clear" />
						<i class="pi p-toolbar-separator" />
						<ToggleButton v-model="reveal" onIcon="pi pi-search" offIcon="pi pi-times" v-tooltip.bottom="'Reveal'" />
					</template>
				</Toolbar>

			</div>
		</div>
	</div>

	<div class="p-col-12">
		<div class="card" lv-display>
			<Card v-if='reveal'>
				<template #content>
					<span class="markdown-body" v-html="rawHtml"></span>
				</template>
			</Card>
			<Card v-else='reveal'>
				<template #content>
					<!-- <div id="app">
						<highlightjs language='html' :code="srcHtml" />
					</div>-->
					<Textarea v-model='srcHtml' readonly :autoResize="true" rows="10" cols="180" />
				</template>
			</Card>
		</div>
	</div>

</template>

<script>
import {ref, computed, nextTick, onMounted, onUpdated, watch} from 'vue';
import {useStore} from 'vuex';

export default {
  setup(props, ctx) {
    const store = useStore();

    onMounted(() => {
      console.log('Mounted');
    });

    onUpdated(() => {
      console.log('Updated');
    });

    const themeChoice = ref('');
    const themeList = [
      {name: 'Github', code: 'github'},
      {name: 'Github Math', code: 'github-math'},
      {name: 'Markdown', code: 'markdown-body'},
    ];

    const reveal = ref(true);
    const revealWatch = watch(reveal, (newVal, oldVal) => {
      if (newVal == true) {
        refresh();
      }
    });

    const filename = computed(() => {
      return store.state.envl.target;
    });

    const rawHtml = computed(() => {
      nextTick(() => {
        MathJax.typeset();
        hljs.highlightAll();
        console.log('Load done.');
      });
      console.log('Loading...');
      return store.state.msg.content;
    });

    const srcHtml = computed(() => {
      console.log('Format');
      return beautify(store.state.msg.content);
    });

    function beautify(html) {
    	return window.html_beautify(html, {indent_size: 2, space_in_empty_paren: true});
    }

    function refresh() {
      MathJax.typesetClear();
      store.dispatch('refresh');
    }

    function clear() {
      store.dispatch('clear');
    }

    return {
      filename,
      rawHtml,
      srcHtml,
      beautify,
      refresh,
      clear,
      themeChoice,
      themeList,
      reveal,
    };
  },
};

</script>

<style scoped lang="scss">
::v-deep(.p-button) {
	margin-left: .5rem;
	margin-right: .5rem;
}

::v-deep(.p-togglebutton) {
	margin-left: .5rem;
	margin-right: .5rem;
}

::v-deep(.p-card .p-card-title) {
	display: -ms-flexbox;
	display: flex;
	-ms-flex-align: center;
	align-items: center;
	-ms-flex-pack: justify;
	justify-content: space-between;
	margin-bottom: 0;
}

::v-deep(.p-toolbar) {
	// background: lightgray;
}

@media screen and (max-width: 960px) {
	.liveview {

		.lv-toolbar.card,
		.lv-display.card {
			overflow: auto;
		}
	}
}

</style>
