<script setup>
import { usePostStore } from "@/stores/post";
import { onMounted } from "vue";
import { uuid } from "vue-uuid";
import { RouterView } from "vue-router";
import SampleMarkdown from "@/assets/markdown/sample.md";
import TheNavigation from "@/components/navigation/TheNavigation.vue";

const store = usePostStore();
</script>

<template>
  <div class="root">
    <TheNavigation />

    <main class="main">
      <content class="content">
        <RouterView class="content" />
      </content>
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
@media (min-width: 400px) and (max-width: 1000px) {
  .content {
    width: 500px;
  }
}
</style>
