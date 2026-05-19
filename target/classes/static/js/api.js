// API Helper - Use proxy to avoid CORS issues
const API = {
    proxy: '/api/proxy',
    
    async get(endpoint) {
        try {
            const response = await fetch(`${this.proxy}?endpoint=${encodeURIComponent(endpoint)}`);
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            return await response.json();
        } catch (error) {
            console.error('API Error:', error);
            throw error;
        }
    }
};
