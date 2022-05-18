<script setup>
import { computed } from "@vue/runtime-core";

const props = defineProps({
  type: String,
});

const title = computed(() => {
  return props.type.charAt(0).toUpperCase() + props.type.slice(1);
});
</script>

<template>
  <div class="category-card">
    <h4 class="category-title">{{ title }}</h4>
    <h3 class="category-number">12</h3>
  </div>
</template>

<style scope>
.category-card {
  width: max-content;
  padding: 20px;
  border-radius: 10px;
  background-color: var(--background-soft);
}
.category-title {
  margin: 0px;
}
.category-number {
  margin: 0px;
}
</style>
