<script setup>
import { useRoute } from "vue-router";
import TagChip from "../components/chip/TagChip.vue";
import { usePostStore } from "@/stores/post";

const store = usePostStore();
const route = useRoute();

const getPost = store.getPostById;
const postId = route.params.id;
let post = getPost(postId);
if(post == undefined) {
    post = {
        "title": "Default",
        "author": "Default",
        "date": "Default",
        "tags": ["default"]
    };
}
</script>

<template>
  <div>
    <div>
      <img />
      <p>
        Written by <span class="post-author">{{ post.author }}</span> on
        <span class="post-date">{{ post.date }}</span>
      </p>
      <h3>{{ post.title }}</h3>
      <TagChip v-for="tag in post.tags" :key="post.id" :tag="tag">{{ tag }}</TagChip>
    </div>
  </div>
</template>

<style scoped>
.post-author {
  color: rgb(100, 100, 100);
  font-weight: 600;
}
.post-date {
  color: rgb(100, 100, 100);
  font-weight: 600;
}
</style>
