<script setup>
import BaseButton from "@/components/button/BaseButton.vue";
</script>

<template>
  <section class="section">
    <h1>New Post</h1>
    <div class="section-container">
        <label class="input-label">Title</label>
        <input type="text" class="input-text"/>
        <label class="input-label">Content</label>
        <textarea class="textarea"></textarea>
    </div>
    <div class="button-container">
        <BaseButton color="primary">Save</BaseButton>
        <BaseButton color="normal">Cancel</BaseButton>
    </div>
  </section>
</template>

<style scoped>
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
    background-color: var(--input-background);
    border: 0px;
    border-radius: 2px;
    padding: 10px 16px;
    font-size: var(--p-font-size);
    margin-bottom: 20px;
    font-family: var(--p-font-family);
}
.input-text:focus {
    outline: none;
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
