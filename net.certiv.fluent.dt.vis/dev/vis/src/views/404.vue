<template>
  <v-card class="mx-auto" max-width="800">
    <v-img class="align-end text-white" height="400" src="/images/binary.jpg" cover>
      <v-card-title>404 - Page not found</v-card-title>
    </v-img>

    <v-card-actions>
      <v-btn class="ma-2" color="#41B883" elevation="0" @click="$router.push('/')">Home</v-btn>
      <v-btn class="ma-2" color="#41B883" elevation="0" @click="$router.push('/index')">Liveview</v-btn>
    </v-card-actions>
  </v-card>
</template>

<script setup lang="ts"></script>
