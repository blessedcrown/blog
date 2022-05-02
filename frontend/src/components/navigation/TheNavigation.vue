<script setup>
import NavTab from "@/components/navigation/NavTab.vue";
</script>

<template>
  <nav class="navigation">
    <NavTab link="dashboard">Dashboard</NavTab>
    <NavTab link="posts">Posts</NavTab>
    <NavTab link="category">Category</NavTab>
    <NavTab link="settings">Settings</NavTab>
  </nav>
</template>

<style scoped>
.navigation {
  width: 400px;
  height: 100%;
  background-color: var(--background-mute);
}
</style>
