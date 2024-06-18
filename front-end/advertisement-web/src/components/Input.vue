<template>
    <v-sheet class="mx-auto -mt-20" width="300">
      <v-form ref="form" @submit.prevent="submitForm">
        <v-text-field
        type="text"
        v-model="firstName"
        label="Jméno"
        :rules="requiredRules"
        ></v-text-field>
        <v-text-field
        type="text"
        v-model="lastName"
        label="Příjmení"
        :rules="requiredRules"
        ></v-text-field>
        <v-text-field 
        type="email"
        :rules="emailRules"
        v-model="email"
        label="Email"
        ></v-text-field>
        <v-text-field
        type="text"
        :rules="requiredRules"
        v-model="city"
        label="Město"
        ></v-text-field>
        <v-text-field
        type="number"
        v-model="price"
        label="Cena"
        ></v-text-field>
        <v-select
        v-model="currency"
        :items="selectCurrency"
        label="Měna"
        required
        ></v-select>
        <v-file-input
        label="Vložte obrázek"
        chips
        multiple
        prepend-icon="mdi-camera"
        ></v-file-input>
      </v-form>
    </v-sheet>
    <v-container fluid>
      <v-textarea
      class="mx-auto"
      width="300"
      clear-icon="mdi-close-circle"
      label="Inzerát"
      model-value="Zadejte svůj inzerát"
      clearable
      ></v-textarea>
    </v-container>
  </template>

<script setup>

  import { ref } from 'vue';

  const firstName = ref("");
  const lastName = ref("");
  const email = ref("");
  const city = ref("");
  const price = ref("");
  const currency = ref("");
  const selectCurrency = ["Kč", "EUR", "USD"]
  const value = ref("");

  const emailRules = [
    v => !!v || "Toto pole je povinné",
    v => /.+@.+\..+/.test(v) || "Uveďte email ve správném tvaru"
  ];
  const requiredRules = [
    v => !!v || "Toto pole je povinné"
  ];
  const submitForm = () => {
    if (form.value.validate()) {
      alert("Formulář je správně vyplněn.")
    } alert("Formulář obsahuje chyby.")
  };

</script>

<style scoped>

</style>