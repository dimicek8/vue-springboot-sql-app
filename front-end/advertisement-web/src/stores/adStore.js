import { defineStore } from "pinia";

export const useAdStore = defineStore('adStore', {
    state: () => ({
        ads: []
    }),
    actions: {
        addAd(ad) {
            this.ads.push(ad);
        }
    }
});