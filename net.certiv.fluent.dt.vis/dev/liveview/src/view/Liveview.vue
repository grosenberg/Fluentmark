<template>
	<div>
		<p>
			<button @click="refresh()">Refresh</button>
			<button @click="clear()">Clear</button>
		</p>
		<div v-html="rawhtml"></div>
		<!-- <highlightjs autodetect :code="code" /> -->
	</div>
</template>

<script>
import {computed, onMounted} from 'vue';
import {useStore} from 'vuex';

export default {
  setup(props, ctx) {
    const store = useStore();

    onMounted(() => {
      console.log('Mounted');
    });

    function refresh() {
      console.log('Refresh button clicked.');
      store.dispatch('refresh');
    }

    function clear() {
      console.log('Clear button clicked.');
      store.dispatch('clear');
    }

    const rawhtml = computed(() => {
      return store.state.msg.content;
    });

    return {
      rawhtml,
      refresh,
      clear,
    };
  },
};
</script>
