import vuetify from './vuetify';
import pinia from '../store';
import router from '../router';
import { loadFonts } from './webfontloader';
import { useAppStore } from '../store/app';
import { useSocketStore } from '../store/socket';
import VueNativeSock from 'vue-native-websocket-vue3';

import 'highlight.js/styles/stackoverflow-light.css';
import hljsCommon from 'highlight.js/lib/common';
import { loadConfig } from '@/plugins/loadConfig';

import type { App } from 'vue';

// called from `@/main.js`
export function registerPlugins(app: App) {
  loadFonts();
  app.use(vuetify);
  app.use(router);
  app.use(pinia);

  // ---- initialize the store default values ----
  const config = loadConfig();

  const store = useAppStore();
  store.setTitle(config.title);
  store.setCopyright(config.copyright);
  store.setWsConnectUrl(config.wsConnectUrl);
  console.log('Configuration initialized: "%s %s: %s".', store.title, store.copyright, store.wsConnectUrl);

  // ---- initialize the router: set page title from route meta ----
  router.afterEach((to) => {
    const store = useAppStore();
    const title = store.title;
    if (to.meta && to.meta.title) {
      document.title = `${title} -- ${to.meta.title}`;
    } else {
      document.title = title;
    }
    console.log('Set document title: %s', document.title);
  });

  // ---- initialize websocket communications ----
  const wsUrl = store.getWsConnectUrl;
  console.log('Starting the WS client on %s', wsUrl);
  app.use(VueNativeSock, wsUrl, {
    store: useSocketStore(),
    format: '',
    reconnection: true,
    reconnectionAttempts: 30,
    reconnectionDelay: 2000,
  });

  // ---- initialize highlight.js ----
  hljsCommon.configure({
    classPrefix: '',
    ignoreUnescapedHTML: true,
  });
  hljsCommon.highlightAuto('<h1>Highlight.js has been registered successfully!</h1>').value;
  // console.log('Known languages: %s', hljsCommon.listLanguages());
}
