import { defineStore } from 'pinia';
import type { State } from '@/store/types/AppTypes';

// export const defaultCodeStyles = [
//   { name: 'Plain', code: 'minimal' },
//   { name: 'Github', code: 'github' },
//   { name: 'Github Math', code: 'github-math' },
//   { name: 'Markdown', code: 'markdown' },
//   { name: 'Test', code: 'test' },
// ];

export const useAppStore = defineStore('app', {
  state: (): State => ({
    enabled: true,
    darkmode: false,
    linkScroll: true,
    title: 'Not set yet!',
    copyright: 1900,
    wsConnectUrl: '',
    sidebarState: false,
    // livestyle: { name: 'Github', code: 'github' },
    // livestyles: defaultCodeStyles,
  }),

  actions: {
    toggleEnabled() {
      this.enabled = !this.enabled;
    },
    setDarkMode(darkmode: boolean) {
      this.darkmode = darkmode;
    },
    toggleSidebar() {
      this.sidebarState = !this.sidebarState;
    },
    setTitle(title: string) {
      this.title = title;
    },
    setCopyright(copyright: number) {
      this.copyright = copyright;
    },
    setWsConnectUrl(url: string) {
      this.wsConnectUrl = url;
    },
    setSidebarState(sidebarState: boolean) {
      this.sidebarState = sidebarState;
    },
    // setLivestyle(livestyle: LiveStyle) {
    //   this.livestyle = livestyle;
    // },
  },
  getters: {
    isEnabled(state) {
      return state.enabled;
    },
    isDarkMode(state) {
      return state.darkmode;
    },
    getTitle(state) {
      return state.title;
    },
    getCopyright(state) {
      return state.copyright;
    },
    getWsConnectUrl(state) {
      return state.wsConnectUrl;
    },
    getSidebarState(state) {
      return state.sidebarState;
    },
    // getLivestyle(state) {
    //   return state.livestyle;
    // },
  },

  // pinia-plugin-persistedstate
  persist: true,
});
