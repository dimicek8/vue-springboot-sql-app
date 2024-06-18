<template>
  <div class="d-flex flex-column">
    <div class="d-flex w-100 justify-center px-6">

      <v-spacer></v-spacer>

      <v-btn
        v-for="icon in icons"
        :key="icon"
        :icon="icon"
        class="mx-4"
        size="small"
        variant="plain"
      ></v-btn>
    </div>

    <div class="px-4 py-2 text-center w-100">
      {{ new Date().getFullYear() }} — <strong>Inzeráty&reg;</strong>
    </div>
    </div>
</template>

<script setup>
import { ref } from 'vue';

const icons = ref([
  'mdi-facebook',
  'mdi-twitter',
  'mdi-linkedin',
  'mdi-instagram',
]);
</script>