<script setup>
defineProps({
  color: {
    type: String,
    default: "primary",
  },
});
</script>

<template>
  <button class="button" :class="color">
    <slot></slot>
  </button>
</template>

<style scoped>
.button {
  padding: 8px 16px;
  border: 0px;
  border-radius: 4px;
  color: white;
  font-size: var(--p-font-size);
  font-family: var(--p-font-family);
}
.primary {
  background-color: var(--primary-color);
}
.normal {
  color: var(--font-color);
  background-color: white;
  border: 1px solid var(--border-color);
}
.button:hover {
  cursor: pointer;
}
</style>
