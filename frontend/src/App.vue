<script setup>
import { RouterView } from "vue-router";
import TheNavigation from "@/components/navigation/TheNavigation.vue";
</script>

<template>
  <div class="root">
    <TheNavigation />

    <main class="main">
      <RouterView class="content" />
    </main>
  </div>
</template>

<style scoped>
.root {
  width: 100vw;
  height: 100vh;
  display: flex;
  position: relative;
}
.main {
  display: flex;
  flex-direction: column;
  align-items: center;
  width: 100%;
  height: 100%;
  padding: 40px;
  margin-top: 50px;
}
.content {
  width: 800px;
}
</style>
