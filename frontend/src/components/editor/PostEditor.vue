<script setup>
import { ref } from "vue";

const isWriting = ref(true);
</script>

<template>
  <div class="editor">
    <div class="editor__tabs">
      <button @click="isWriting = true">Write</button>
      <button @click="isWriting = false">Preview</button>
    </div>

    <textarea
      v-if="isWriting"
      class="textarea"
      placeholder="Content"
      v-model="content"
    ></textarea>
    <VueShowdown
      v-else
      class="preview"
      placeholder="preview"
      :markdown="content"
      flavor="github"
      :options="{ emoji: true }"
    />
  </div>
</template>

<style scoped>
.editor {
  display: flex;
  flex-direction: column;
  width: 100%;
}
.editor__tabs {
  display: flex;
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
  border-right: 2px solid var(--border-color);
  width: 100%;
}
.textarea:focus {
  outline: none;
}
.preview {
  background-color: var(--input-background);
  width: 100%;
  padding: 10px 16px;
}
</style>
