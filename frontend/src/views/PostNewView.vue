<script setup>
import { format } from "date-fns";
import { reactive, ref } from "vue";
import BaseButton from "@/components/button/BaseButton.vue";
import PostModal from "@/components/modal/PostModal.vue";
import PostEditor from "@/components/editor/PostEditor.vue";
import TextField from "@/components/input/TextField.vue";
import { usePostStore } from "@/stores/post";

const store = usePostStore();

const isModalOpen = ref(false);
const post = reactive({
  id: -1,
  image: "",
  title: "",
  date: "",
  author: "",
  tags: [],
  content: "",
});

const savePost = () => {
  store.savePost(post);
  openModal();
}

const openModal = () => {
  isModalOpen.value = true;
};

const closeModal = () => {
  isModalOpen.value = false;
};
</script>

<template>
  <section class="section">
    <PostModal
      v-if="isModalOpen"
      :post="post"
      @closeModal="closeModal"
    ></PostModal>
    <h1>New Post</h1>
    <div class="section-container">
      <TextField class="input-text" placeholder="Title" v-model="post.title"></TextField>
      <PostEditor v-model="post.content"></PostEditor>
    </div>
    <div class="button-container">
      <BaseButton color="primary" @click="savePost">Save</BaseButton>
    </div>
  </section>
</template>

<style scoped>
.section {
  padding-bottom: 50px;
}
.section-container {
  display: flex;
  flex-direction: column;
  margin-bottom: 30px;
}
.input-label {
  font-size: var(--h5-font-size);
  font-weight: var(--h-font-weight);
}
.input-text {
  margin-bottom: 20px;
}
.textarea {
  background-color: var(--input-background);
  border: 0px;
  border-radius: 2px;
  padding: 10px 16px;
  font-size: var(--p-font-size);
  font-family: var(--p-font-family);
  resize: none;
  height: 600px;
}
.textarea:focus {
  outline: none;
}
.button-container {
  display: flex;
  justify-content: space-between;
}
</style>
