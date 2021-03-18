<template>
	<div class="p-grid liveview">
		<div class="p-col-12">
			<div class="card lv-toolbar">

				<Toolbar>
					<template v-slot:left>
						<strong>{{filename}}</strong>
					</template>

					<template v-slot:right>
						<Button label="Refresh" icon="pi pi-plus" style="margin-right: .5em" @click="refresh" />
						<Button label="Clear" icon="pi pi-times" class="p-button-secondary" @click="clear" />
					</template>
				</Toolbar>

			</div>
		</div>
	</div>

	<div class="p-col-12">
		<div class="card" lv-display>
			<Card>
				<template #content>
					<span class="markdown-body" v-html="rawhtml"></span>
				</template>
			</Card>
		</div>
	</div>

</template>

<script>
import {computed, nextTick, onMounted, onUpdated} from 'vue';
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

    const filename = computed(() => {
      return store.state.envl.target;
    });

    const rawhtml = computed(() => {
      nextTick(() => {
        MathJax.typeset();
        hljs.highlightAll();
        console.log('Load done.');
      });
      console.log('Loading...');
      return store.state.msg.content;
    });

    function refresh() {
      store.dispatch('refresh');
    }

    function clear() {
      store.dispatch('clear');
    }

    return {
      filename,
      rawhtml,
      refresh,
      clear,
    };
  },
};

</script>

<style scoped lang="scss">
p {
	line-height: 1.5;
	margin: 0;
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

::v-deep(button) {
	margin-right: .25em;
	margin-left: .25em;
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
