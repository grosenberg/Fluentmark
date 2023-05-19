import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router';

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    component: () => import('@/layouts/default/Default.vue'),
    meta: {
      icon: 'mdi-home',
      title: 'Home',
      sidebar: true,
    },
    children: [
      {
        path: '',
        name: 'Home',
        component: () => import('@/views/Home.vue'),
        meta: {
          icon: 'mdi-information-outline',
          title: 'Home',
          sidebar: true,
        },
      },
    ],
  },

  // ---------------------------------

  {
    // Live client page at http://127.0.0.1:9025/index-0305.html
    path: '/:pathMatch(index.*)*',
    name: 'LiveView',
    component: () => import('@/views/Liveview.vue'),
    meta: {
      icon: 'mdi-folder-outline',
      title: 'Live View',
      sidebar: true,
    },
  },

  // ---------------------------------

  {
    path: '/:pathMatch(.*)*',
    name: '404',
    component: () => import('@/views/404.vue'),
    meta: {
      icon: 'mdi-information-outline',
      title: '404',
      sidebar: false,
    },
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
