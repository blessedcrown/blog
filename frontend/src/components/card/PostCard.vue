<script setup>
import { computed } from "@vue/runtime-core";
import { RouterLink } from "vue-router";

const props = defineProps({
  id: String,
  title: String,
  date: String,
  image: String,
});

const shortTitle = computed(() => {
  return props.title.length < 50
    ? props.title
    : props.title.slice(0, 47) + "...";
});
</script>

<template>
  <RouterLink class="post-card" :to="{name: 'posts', params: { id: id}}">
    <img class="post-image" :src="'/src/assets/images/' + image" />
    <div class="post-right">
      <h4 class="post-title">{{ shortTitle }}</h4>
      <p class="post-date">{{ date }}</p>
    </div>
  </RouterLink>
</template>

<style scope>
.post-card {
  display: flex;
  width: max-content;
  height: max-content;
  text-decoration: none;
}
.post-card:hover {
  cursor: pointer;
}
.post-image {
  width: 200px;
  height: 100px;
  border-radius: 10px;
  margin-right: 30px;
}
.post-right {
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  padding: 10px 0px;
}
.post-title {
  margin: 0px;
}
.post-date {
  margin: 0px;
}
</style>
