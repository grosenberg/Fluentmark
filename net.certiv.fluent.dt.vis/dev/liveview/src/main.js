import { createApp } from 'vue'

import App from './App.vue'
const app = createApp(App)

import { store } from './store';
app.use(store)

import hljs from 'highlight.js';
app.use(hljs.vuePlugin);

import VueNativeSock from 'vue-native-websocket-vue3';
app.use(VueNativeSock, 'ws://localhost:9025/liveview', {
  store: store,
  format: 'json',
  reconnection: true,
  reconnectionAttempts: 5,
  reconnectionDelay: 3000,
});

app.mount('#app');
