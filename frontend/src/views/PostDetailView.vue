<script setup>
import { ref, reactive } from "vue";
import { useRoute } from "vue-router";
import TagChip from "../components/chip/TagChip.vue";
import { storeToRefs } from "pinia";
import { usePostStore } from "@/stores/post";
import { useCommentStore } from "@/stores/comment";
import BaseButton from "@/components/button/BaseButton.vue";
import CommentEditor from "@/components/editor/CommentEditor.vue";
import { format } from 'date-fns';

const route = useRoute();
const postId = route.params.id;

/* POST */
const postStore = usePostStore();

const getPost = postStore.getPostById;
let post = getPost(postId);
if (post == undefined) {
  post = {
    title: "Default",
    author: "Default",
    date: "Default",
    tags: ["default"],
    content: "Default",
  };
}

const commentStore = useCommentStore();
const { comments } = storeToRefs(commentStore);
const filteredComments = ref([]);
filteredComments.value = comments.value.filter((comment) => comment.postId === postId);
const commentInEditor = ref("");

const onCreateComment = () => {
  console.log(commentInEditor.value);

  let newComment = {
    id: Math.random(),
    postId: postId,
    date: format(new Date(), 'yyyy/MM/dd'),
    reply: commentInEditor.value,
  }

  commentStore.addComment(newComment);
  filteredComments.value = [...filteredComments.value, newComment];
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
         <VueShowdown
            class="content"
            flavor="github"
            :markdown="post.content"
            :options="{ emoji: true }"/>
      </div>
      <div class="comment-container">
        <h2>Comments</h2>
        <CommentEditor class="comment-editor" v-model="commentInEditor"></CommentEditor>
        <BaseButton @click="onCreateComment">Comment</BaseButton>
      </div>
      <div class="comment" v-for="comment in filteredComments">
        <div class="comment__avatar"></div>
        <div class="comment__section">
          <p class="comment__date"><span class="comment__author">Guest</span> commented on {{comment.date}}</p>
          <p>{{comment.reply}}</p>
        </div>
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
.comment-editor {
  margin-bottom: 20px;
}
.comment-container {
  margin-bottom: 50px;
}

.comment {
  display: flex;
  margin-bottom: 20px;
}
.comment__avatar {
  border-radius: 5px;
  background-color: var(--navbar-color);
  width: 50px;
  height: 50px;
}
.comment__section {
  background-color: var(--navbar-color);
  border-radius: 5px;
  padding: 10px 20px;
  position: relative;
  margin-left: 60px;
  width: 100%;
}
.comment__section::before {
  content: "";
  position: absolute;
  left: 0;
  width: 0px;
  height: 0px;
  border-top: 10px solid transparent;
  border-bottom: 10px solid transparent;
  border-right: 10px solid var(--navbar-color);
  transform: translateX(-100%);
}
.comment__author {
  font-weight: 600;
}
.comment__date {
  padding-bottom: 10px;
  border-bottom: 1px solid rgba(0,0,0,0.07);
}
</style>
