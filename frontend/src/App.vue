<script setup>
import { RouterView } from "vue-router";
import TheNavigation from "@/components/navigation/TheNavigation.vue";
</script>

<template>
  <div class="root">
    <TheNavigation />

    <main class="main">
      <RouterView />
    </main>
  </div>
</template>

<style scoped>
.root {
  width: 100vw;
  height: 100vh;
  display: flex;
}
.main {
  display: flex;
  flex-direction: column;
  width: 100%;
  height: 100%;
  padding: 40px;
  margin-left: 340px;
}
</style>
