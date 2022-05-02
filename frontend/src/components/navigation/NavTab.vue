<script setup>
import { RouterLink } from "vue-router";

const props = defineProps({
  link: String,
});
</script>

<template>
  <div class="nav-tab">
    <RouterLink :to="link">
      <slot></slot>
    </RouterLink>
  </div>
</template>

<style scoped>
.nav-tab {
  width: 100%;
  color: white;
}
</style>
