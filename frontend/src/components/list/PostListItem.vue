<script setup>
defineProps({
  link: String,
  title: String,
  date: String,
});
</script>

<template>
  <router-link :to="{ name: 'posts', params: { id: link } }" class="item">
    <h5 class="item-title">{{ title }}</h5>
    <p class="item-date">{{ date }}</p>
  </router-link>
</template>

<style scoped>
.item {
  width: 100%;
  padding: 10px 20px;
  border-radius: 5px;
  display: flex;
  justify-content: space-between;
  text-decoration: none;
  margin: 0px;
}
.item:hover {
  cursor: pointer;
  background-color: rgba(0, 0, 0, 0.03);
}
.item-title {
  margin: 0px;
}
.item-date {
  margin: 0px;
}
</style>
