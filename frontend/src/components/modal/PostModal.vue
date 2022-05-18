<script setup>
import { ref } from "vue";
import useFileList from "@/compositions/file-list";
import BaseButton from "@/components/button/BaseButton.vue";
import TextField from "@/components/input/TextField.vue";
import DropZone from "@/components/dropzone/DropZone.vue";

defineProps({ post: Object });
defineEmits(["closeModal"]);

const uploadedFile = ref();
const isUploaded = ref(false);

const toggleIsUploaded = () => {
  isUploaded.value = !isUploaded.value;
};

function onInputChange(e) {
  let image = e.target.files[0];
  let reader = new FileReader();
  reader.readAsDataURL(image);
  reader.onload = (e) => {
    uploadedFile.value = e.target.result;
    e.target.value = null;
    isUploaded.value = true;
  };
}
</script>

<template>
  <div class="backdrop" @click.self="$emit('closeModal')">
    <div class="modal">
      <h1 class="title">Publish</h1>

      <div class="input-container">
        <h4 class="label">Upload Image</h4>
        <DropZone
          class="upload-area"
          #default="{ dropZoneActive }"
          :class="{ 'upload-active': dropZoneActive }"
          v-if="!isUploaded"
        >
          <label class="upload-wrapper" for="file-input">
            <div v-if="dropZoneActive">
              <div>Drop Them</div>
            </div>
            <font-awesome-icon
              class="upload-icon"
              icon="upload"
            ></font-awesome-icon>
            <p class="upload-text">
              Include an image to make it more inviting for readers!
            </p>

            <input
              type="file"
              accept="image/jpeg, image/png, image/heic, image/heif"
              style="display: none"
              id="file-input"
              @change="onInputChange"
            />
          </label>
        </DropZone>
        <div class="image-container" v-if="isUploaded">
          <img class="upload-image" :src="uploadedFile" />
          <BaseButton
            @click="toggleIsUploaded"
            class="cancel-button"
            color="normal"
            >Cancel Upload</BaseButton
          >
        </div>
      </div>

      <div class="input-container">
        <h4 class="label">Add a tag</h4>
        <TextField placeholder="Type tag name here"></TextField>
      </div>

      <BaseButton color="primary">Publish</BaseButton>
    </div>
  </div>
</template>

<style scoped>
.backdrop {
  position: fixed;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  background-color: rgba(0, 0, 0, 0.5);
  z-index: 999999;
}
.modal {
  margin: 80px auto;
  background-color: white;
  border-radius: 5px;
  padding: 20px;
  width: max-content;
}
.title {
  margin-bottom: 26px;
}
.input-container {
  display: flex;
  flex-direction: column;
  margin-bottom: 20px;
}
.label {
  margin-bottom: 10px;
}
.upload-area {
  width: 700px;
  height: 400px;
  background-color: var(--input-background);
}
.upload-wrapper {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}
.upload-wrapper:hover {
  cursor: pointer;
}
.upload-icon {
  font-size: var(--h1-font-size);
  margin-bottom: 20px;
}
.upload-text {
  color: var(--font-color-light);
  font-size: var(--h5-font-size);
}
.upload-active {
  background-color: var(--input-background-hover);
}
.image-container {
  position: relative;
}
.upload-image {
  width: 700px;
  height: 400px;
}
.cancel-button {
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  margin: auto;
  width: max-content;
  height: max-content;
}
</style>
