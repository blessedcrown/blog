<script setup>
import { useRoute } from "vue-router";

const route = useRoute();
const tagName = route.params.tag;
</script>

<template>
  <div class="content-top">
    <h1>Tags</h1>
    <div class="category-container">
      <TagChip tag="frontend">Frontend</TagChip>
    </div>
  </div>
  <h3>
    Posts tagged: <span class="tag-name">{{ tagName }}</span>
  </h3>
  <p class="description"><span class="post-count">3</span> posts found</p>
</template>

<style scoped>
.content-top {
  width: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
}
.tag-name {
  border-bottom: 3px solid var(--background-mute);
}
.description {
  font-size: var(--h5-font-size);
  color: rgb(100, 100, 100);
}
.post-count {
  color: black;
}
</style>
