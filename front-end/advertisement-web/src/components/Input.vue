<template>
    <v-sheet class="mx-auto -mt-20" width="300">
      <v-form ref="form" @submit.prevent="submitForm">
        <v-text-field
        type="text"
        v-model="ad.firstName"
        label="Jméno"
        :rules="requiredRules"
        ></v-text-field>
        <v-text-field
        type="text"
        v-model="ad.lastName"
        label="Příjmení"
        :rules="requiredRules"
        ></v-text-field>
        <v-text-field 
        type="email"
        v-model="ad.email"
        label="Email"
        :rules="emailRules"
        ></v-text-field>
        <v-text-field
        type="text"
        v-model="ad.city"
        label="Město"
        :rules="requiredRules"
        ></v-text-field>
        <v-text-field
        type="number"
        v-model="ad.price"
        label="Cena"
        :rules="priceRules"
        min="0"
        ></v-text-field>
        <v-select
        v-model="ad.currency"
        label="Měna"
        :items="selectCurrency"
        required
        ></v-select>
        <v-file-input
        label="Vložte obrázek"
        chips
        multiple
        prepend-icon="mdi-camera"
        @change="handleFileChange"
        ></v-file-input>
      </v-form>
    </v-sheet>
    <v-container fluid>
      <v-textarea
      v-model="ad.description"
      class="mx-auto"
      width="300"
      clear-icon="mdi-close-circle"
      label="Inzerát"
      placeholder="Zadejte svůj inzerát"
      clearable
      ></v-textarea>
    </v-container>
  </template>

<script setup>

  import { defineProps } from 'vue';

  const props = defineProps({
    newAd: Object,
    required: true
  });

  const ad = props.newAd;
  
  const handleFileChange = (event) => {
  const files = Array.from(event.target.files);
  ad.files = files.map(file => {
    return {
      name: file.name,
      url: URL.createObjectURL(file),
      rawFile: file
    };
  });
};

  // import { ref } from 'vue';

  // const newAd = ref({
  //     firstName: "",
  //     lastName: "",
  //     email: "",
  //     city: "",
  //     price: "",
  //     currency: "",
  //     selectCurrency: "",
  //     description: ""
  //   });

  // const firstName = ref("");
  // const lastName = ref("");
  // const email = ref("");
  // const city = ref("");
  // const price = ref("");
  // const currency = ref("");
  const selectCurrency = ["Kč", "EUR", "USD"];

  const emailRules = [
    v => !!v || "Toto pole je povinné",
    v => /.+@.+\..+/.test(v) || "Uveďte email ve správném tvaru"
  ];
  const requiredRules = [
    v => !!v || "Toto pole je povinné"
  ];
  const priceRules = [
    v => v > 0 || "Cena nesmí být nižší než nula"
  ];
  const submitForm = () => {
    if (form.value.validate()) {
      alert("Formulář je správně vyplněn.")
    } else {
      alert("Formulář obsahuje chyby.")
    }
  };

</script>

<style scoped>

</style>