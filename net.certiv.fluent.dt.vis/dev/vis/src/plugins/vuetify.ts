import '@mdi/font/css/materialdesignicons.css';
import 'vuetify/styles';

import { createVuetify, ThemeDefinition } from 'vuetify';
import { md3 } from 'vuetify/blueprints';
import { aliases, mdi } from 'vuetify/iconsets/mdi';

const LightTheme: ThemeDefinition = {
  dark: false,
  colors: {
    primary: '#344767',
    secondary: '#fcfbff',
    // surface: '#EAEAEA', // toolbar/nav-drawer/background
    accent: '#6386e1',
    title: '#e7e3FC',
    content: '#333333',
    background: '#F8F9FA',
    info: '#2196F3',
    success: '#4CAF50',
    warning: '#FB8C00',
    error: '#B00020',
    // custom values
    link_mark: '#4183c4',
    link_mark_visited: '#cc0000',
    shade: '#cccccc',
    quoted: '#777777',
    shade_darker: '#dddddd',
    shaded_bg: '#f8f8f8',
    inner_span: '#333333',
    codeblock: '#eaeaea',
    pmenu: '#EAEAEA',
  },
};

const DarkTheme: ThemeDefinition = {
  dark: true,
  colors: {
    primary: '#4EB4F4',
    secondary: '#219BE8',
    // surface: '#202225', // toolbar/nav-drawer/background
    accent: '#6386e1',
    title: '#e7e3FC',
    content: '#E7E3FC',
    background: '#2d2d2d',
    info: '#24a6c5',
    success: '#e47171',
    warning: '#e47171',
    error: '#ef476f',
    // custom values
    link_mark: '#4183c4',
    link_mark_visited: '#cc0000',
    shade: '#999999',
    quoted: '#E9E3EF',
    shade_darker: '#dddddd',
    shaded_bg: '#455a64',
    inner_span: '#333333',
    codeblock: '#eaeaea',
    pmenu: '#606060',
  },
};

export default createVuetify({
  blueprint: md3,
  icons: {
    defaultSet: 'mdi',
    aliases,
    sets: {
      mdi,
    },
  },
  theme: {
    defaultTheme: 'dark',
    themes: {
      light: LightTheme,
      dark: DarkTheme,
    },
  },
});
