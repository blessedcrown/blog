<script setup>
import { computed } from '@vue/runtime-core';

const props = defineProps({
  "title": String,
  "date": String,
  "image": String,
});

const shortTitle = computed(() => {
  return props.title.length < 40 ? props.title : props.title.slice(0, 37) + "..."
})
</script>

<template>
  <div class="post-card">
    <img class="post-image" :src="'/src/assets/images/' + image" />
    <div class="post-right">
      <h4 class="post-title">{{ shortTitle }}</h4>
      <p class="post-date">{{ date }}</p>
    </div>
  </div>
</template>

<style scope>
.post-card {
  display: flex;
  width: max-content;
  height: max-content;
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
