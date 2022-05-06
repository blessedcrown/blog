<script setup>
import PostListItem from "@/components/list/PostListItem.vue";
import TextField from "@/components/input/TextField.vue";
import { storeToRefs } from "pinia";
import { usePostStore } from "@/stores/post";

const store = usePostStore();
const { posts } = storeToRefs(store);

</script>

<template>
  <section class="section-top">
    <h1>Articles</h1>
    <p class="description">Search up all the dev related post here!</p>
    <TextField></TextField>
  </section>

  <section class="post-list">
    <PostListItem v-for="post in posts" :link="post.id" :title="post.title" :date="post.date"></PostListItem>
  </section>
</template>

<style scoped>
.section-top {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 40px;
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
