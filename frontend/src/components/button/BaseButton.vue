<script setup></script>

<template>
  <button class="button">
    <slot></slot>
  </button>
</template>

<style scoped>
.button {
  padding: 5px 10px;
  border: 0px;
  border-radius: 4px;
  background-color: var(--primary-color);
  color: white;
}
.button:hover {
  cursor: pointer;
}
</style>
