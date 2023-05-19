<template>
  <v-container fluid>
    <v-row justify="space-around">
      <v-col cols="12" md="12">
        <v-card class="mx-auto">
          <v-toolbar id="hdrId" :image="hdrImg">
            <v-toolbar-title class="text-h5">
              Live View
              <div>
                <v-label class="ml-4">
                  <v-icon class="mr-2" icon="mdi-file" />
                  {{ filename }}
                </v-label>
              </div>
            </v-toolbar-title>

            <v-spacer />

            <v-btn class="ml-4" prepend-icon="mdi-autorenew" @click="toggleLink">
              {{ link ? 'Link Scroll' : 'UnLink Scroll' }}
            </v-btn>

            <v-btn class="ml-4" prepend-icon="mdi-refresh" @click="doRefresh"> Refresh </v-btn>

            <v-btn class="ml-4" prepend-icon="mdi-details" @click="toggleReveal">
              {{ reveal ? 'Code' : 'Live' }}
            </v-btn>

            <v-menu v-model="optsMenu" :close-on-content-click="false" location="end">
              <template v-slot:activator="{ props }">
                <v-btn v-bind="props" icon="mdi-dots-vertical" />
              </template>

              <!-- Settings Popup -->
              <v-card min-width="300">
                <v-list class="pmenu">
                  <v-list-item prepend-icon="mdi-cog-outline" title="Settings" />
                </v-list>

                <v-divider />

                <v-list class="pmenu">
                  <v-list-item>
                    <v-switch label="Display mode" v-model="tmode" inset hide-details @change="toggleDarkMode">
                      <template v-slot:prepend>
                        <div v-if="theme.global.current.value.dark">
                          <v-icon color="blue-lighten-2" icon="mdi-moon-waxing-crescent" />
                        </div>
                        <div v-else>
                          <v-icon color="yellow-darken-2" icon="mdi-white-balance-sunny" />
                        </div>
                      </template>
                    </v-switch>
                  </v-list-item>
                </v-list>
              </v-card>
            </v-menu>
          </v-toolbar>

          <v-card-text>
            <div id="boxId" class="ms-1 mb-2 scrolls">
              <div v-if="reveal">
                <LiveArea :linkScroll="link" :mathjax="props.mathjax" />
              </div>
              <div v-else>
                <CodeArea :lang="props.lang" />
              </div>
            </div>
          </v-card-text>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script setup lang="ts">
  import { computed, onMounted, onUnmounted, nextTick, ref } from 'vue';
  import { useAppStore } from '@/store/app';
  import { useSocketStore } from '@/store/socket';

  import { useTheme } from 'vuetify';

  import LiveArea from '@/components/LiveArea.vue';
  import CodeArea from '@/components/CodeArea.vue';

  import { clearMathJax } from '@/plugins/mathjax';
  import { calcHeight } from '@/plugins/scrollTo';

  const props = defineProps({
    lang: { type: String, default: 'autodetect' },
    mathjax: { type: Boolean, default: true },
  });

  const store = useAppStore();
  const wsStore = useSocketStore();

  // buttons: scroll link with editor
  const link = ref(store.linkScroll);
  // buttons: live (raw) vs code display state
  const reveal = ref(true);

  // options menu
  const optsMenu = ref(false);

  const theme = useTheme();
  const tmode = ref(theme.global.current.value.dark ? 1 : 0); // toggle button model

  const hdrImg = computed(() => (theme.global.current.value.dark ? '/images/hdr-blue.jpg' : '/images/hdr-silver.png'));

  onMounted(() => {
    nextTick(() => {
      calcHeight();
    });
    window.addEventListener('resize', calcHeight);

    darkMode(store.isDarkMode);
    tmode.value = store.isDarkMode ? 1 : 0;
  });

  onUnmounted(() => {
    window.removeEventListener('resize', calcHeight);
  });

  function toggleDarkMode() {
    darkMode(!store.isDarkMode);
  }

  function darkMode(enabled: boolean) {
    enabled ? (theme.global.name.value = 'dark') : (theme.global.name.value = 'light');
    store.setDarkMode(enabled);
  }

  function toggleReveal() {
    reveal.value = !reveal.value;
    if (reveal.value == true) doRefresh();
  }

  function toggleLink() {
    link.value = !link.value;
    store.linkScroll = link.value;
    if (link.value) doRefresh();
  }

  const filename = computed(() => {
    const name = wsStore.envl.target;
    return name ? name : '<Unspecified>';
  });

  function doRefresh() {
    clearMathJax();
    wsStore.refresh();
  }

  function doClear() {
    wsStore.clear();
  }
</script>

<style scoped lang="scss">
  .pmenu {
    background: rgb(var(--v-theme-pmenu));
  }
  .scrolls {
    overflow-y: auto;
    height: 600px;
  }
</style>
