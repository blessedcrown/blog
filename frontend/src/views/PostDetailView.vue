<script setup>
import { useRoute } from "vue-router";
import TagChip from "../components/chip/TagChip.vue";
import { usePostStore } from "@/stores/post";
import MarkdownSample from "@/assets/markdown/sample.md";

const store = usePostStore();
const route = useRoute();

const getPost = store.getPostById;
const postId = route.params.id;
let post = getPost(postId);
if (post == undefined) {
  post = {
    title: "Default",
    author: "Default",
    date: "Default",
    tags: ["default"],
    content: "Default"
  };
}
</script>

<template>
  <div>
    <div>
      <img />
      <p class="post-description">
        Written by <span class="post-author">{{ post.author }}</span> on
        <span class="post-date">{{ post.date }}</span>
      </p>
      <h1>{{ post.title }}</h1>
      <TagChip v-for="tag in post.tags" :key="post.id" :tag="tag">{{
        tag
      }}</TagChip>
      <div class="content-container">
        <MarkdownSample></MarkdownSample>
      </div>
    </div>
  </div>
</template>

<style scoped>
.post-description {
  margin: 0px;
}
.post-author {
  color: rgb(100, 100, 100);
  font-weight: 600;
}
.post-date {
  color: rgb(100, 100, 100);
  font-weight: 600;
}
.content-container {
  margin: 50px 0px;
}
</style>
