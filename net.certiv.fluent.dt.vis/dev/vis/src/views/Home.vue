<template>
  <v-container class="container">
    <section class="page">
      <img alt="NFlow logo" height="128" src="@/assets/nflow.png" />
      <h1>{{ title }}</h1>
      <h4>Certiv Analytics &copy; {{ mark }}</h4>

      <v-divider class="ma-4" />

      <div class="buttons-container">
        <v-btn class="ma-2" color="primary" elevation="4" @click="count++">
          <span> Count: {{ count }} </span>
        </v-btn>
      </div>

      <div class="state-container">
        <v-btn v-if="enabled" class="ma-2 text-none" color="blue-lighten-2" @click="toggleEnabled">
          <v-icon start icon="mdi-thumb-up" />
          Websockets Enabled
        </v-btn>
        <v-btn v-else class="ma-2 text-none" color="red-lighten-2" @click="toggleEnabled">
          <v-icon start icon="mdi-thumb-down" />
          Websockets Disabled
        </v-btn>
      </div>
      <div class="state-container">
        <v-label v-if="enabled">(click to disconnect)</v-label>
        <v-label v-else>(click to attempt reconnection)</v-label>
      </div>

      <v-divider />
      <v-btn class="ma-2" color="#41B883" elevation="0" @click="$router.push('/index')">Liveview</v-btn>
    </section>
  </v-container>
</template>

<script setup lang="ts">
  import { computed, ref } from 'vue';
  import { useAppStore } from '@/store/app';

  // defineProps<{ msg: String }>();

  const count = ref(0);
  const store = useAppStore();
  const title = store.getTitle;

  const copr = store.getCopyright;
  const year = new Date().getFullYear();

  const mark = computed(() => {
    return copr - year != 0 ? copr + ' - ' + year : copr;
  });

  const enabled = computed(() => store.isEnabled);

  function toggleEnabled() {
    store.toggleEnabled();
  }
</script>

<style lang="scss" scoped>
  section.page {
    min-height: calc(100vh - 56px - 52px - 40px);
    display: flex;
    flex-direction: column;
    text-align: center;
    align-items: center;
    justify-content: center;
  }
</style>
