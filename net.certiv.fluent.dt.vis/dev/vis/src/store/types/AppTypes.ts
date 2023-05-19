export interface State {
  enabled: boolean;
  darkmode: boolean; // theme mode
  linkScroll: boolean;
  title: string;
  copyright: number;
  wsConnectUrl: string;
  sidebarState: boolean;
  // livestyle: LiveStyle; // current liveview stylesheet name/code
  // livestyles: LiveStyle[]; // liveview stylesheet name/code
}

// export interface LiveStyle {
//   name: string; // display name
//   code: string; // formal stylesheet name
// }
