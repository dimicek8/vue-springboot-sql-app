<template>
    <div>
        <div v-for="ad in ads" :key="ad.email">
            <p>{{ ad.firstName }} {{ ad.lastName }}</p>
            <p>{{ ad.email }}</p>
            <p>{{ ad.city }}</p>
            <p>{{ ad.price }} {{ ad.currency }}</p>
            <p>{{ ad.description }}</p>
            <div v-if="ad.files && ad.files.length > 0">
                <div v-for="(file, index) in ad.files" :key="index">
                    <img v-if="file.url" :src="file.url" alt="Obrázek" width="100"/>
                </div>
            </div>
        </div>
    </div>
    
</template>

<script setup>

import { useAdStore } from '../stores/adStore';

const adStore = useAdStore();
const ads = adStore.ads;

</script>