<template>
    <div>
        <div v-for="ad in ads" :key="ad.email">
            <p>{{ ad.firstName }} {{ ad.lastName }}</p>
            <p>{{ ad.email }}</p>
            <p>{{ ad.city }}</p>
            <p>{{ ad.price }} {{ ad.currency }}</p>
            <p>{{ ad.description }}</p>
            <div v-if="ad.fileContent">
                    <img :src="`data:image/jpeg;base64,${ad.fileContent}`" alt="Obrázek" width="100"/>
            </div>
        </div>
    </div>
    
</template>

<script setup>

import { ref, onMounted } from 'vue';
import api from '../api';
import { useAdStore } from '../stores/adStore';

const adStore = useAdStore();
const ads = ref([]);

onMounted(() => {
    api.getAds()
        .then(response => {
            ads.value = response.data;
        })
        .catch(error => {
            console.log("Došlo k chybě: ", error);
        });
});

</script>