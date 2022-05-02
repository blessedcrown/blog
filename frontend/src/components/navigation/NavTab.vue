<script setup>
import { RouterLink } from "vue-router";

const props = defineProps({
  link: String,
});
</script>

<template>
  <div class="nav-tab">
    <RouterLink class="nav-link" :to="link">
      <slot></slot>
    </RouterLink>
  </div>
</template>

<style scoped>
.nav-tab {
  width: 120px;
  color: white;
  margin-bottom: 10px;
}
.nav-link {
  font-size: var(--h5-font-size);
  color: white;
  text-decoration: none;
}
</style>
