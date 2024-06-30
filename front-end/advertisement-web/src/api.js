import axios from 'axios';

const api = axios.create({
    baseURL: 'http://localhost:8080/api',
    withCredentials: false,
    headers: {
        'Accept': 'application/json',
        'Content-Type': 'application/json'
    }
});

export default {
    getAds() {
        return api.get('/ads');
    },
    getAd(id) {
        return api.get('/ads/' + id);
    },
    postAd(ad) {
        const formData = new FormData();
        formData.append('ad', JSON.stringify({
            firstName: ad.firstName,
            lastName: ad.lastName,
            email: ad.email,
            city: ad.city,
            price: ad.price,
            currency: ad.currency,
            description: ad.description
        }));
        if (ad.files && ad.files.length > 0) {
            ad.files.forEach((fileObj, index) => {
                formData.append('file', fileObj.rawFile);
            });
        } else {
            console.log("No files to upload")
        }
        return api.post('/ads', formData, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        });
    },
    updateAd(id, ad) {
        const formData = new FormData();
        formData.append('ad', JSON.stringify({
            firstName: ad.firstName,
            lastName: ad.lastName,
            email: ad.email,
            city: ad.city,
            price: ad.price,
            currency: ad.currency,
            description: ad.description
        }));
        if (ad.files && ad.files.length > 0) {
            ad.files.forEach((fileObj, index) => {
                formData.append('file', fileObj.rawFile);
            });
        }
        return api.put('/ads/' + id, formData, {
            headers: {
                'Content-Type': 'multipart/form-data'
            }
        });
    },
    deleteAd(id) {
        return api.delete('/api/' + id);
    }
};