<script setup>
defineProps({
  tag: String,
});
</script>

<template>
  <router-link :to="{ name: 'tags', params: { tag: tag } }" class="chip">
    <slot></slot>
  </router-link>
</template>

<style scope>
.chip {
  width: max-content;
  border-radius: 10px;
  border: 1px solid rgb(210, 210, 210);
  padding: 4px 10px;
  box-shadow: 0px 0px 1px rgb(210, 210, 210);
  text-decoration: none;
  font-weight: 600;
  color: rgb(100, 100, 100);
}
.chip:hover {
  border: 1px solid var(--primary-color);
  color: var(--primary-color);
}
</style>
