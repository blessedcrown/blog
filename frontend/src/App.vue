<script setup>
import { RouterView } from "vue-router";
import TheNavigation from "@/components/navigation/TheNavigation.vue";
</script>

<template>
  <div class="root">
    <TheNavigation />

    <RouterView />
  </div>
</template>

<style scoped>
.root {
  width: 100vw;
  height: 100vh;
  display: flex;
}
</style>
