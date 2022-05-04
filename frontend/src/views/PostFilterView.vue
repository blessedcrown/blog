<script setup>
import { useRoute } from "vue-router";

const route = useRoute();
const tagName = route.params.tag;

</script>

<template>
  <h3>Posts tagged: <span class="tag-name">{{tagName}}</span></h3>
  <p class="description"><span class="post-count">3</span> posts found</p>
</template>

<style scoped>
.tag-name {
    border-bottom: 3px solid var(--background-mute);
}
.description {
    font-size: var(--h5-font-size);
    color: rgb(100,100,100);
}
.post-count {
    color: black;
}
</style>