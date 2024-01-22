self.addEventListener('install', event => {
  console.debug('Installing SW');
  const installPromise = new Promise(function (resolve, reject) {
    // Do install stuff, like caching resources, etc.
    resolve();
  });

  event.waitUntil(installPromise);
});

self.addEventListener('fetch', event => {
  const fetchPromise = new Promise((resolve, reject) => {
    // Try to get from remote
    fetch(event.request).then(response => {
      // We have internet, try to cache it
      caches.open('static').then(cache => {
        try {
          cache.add(event.request);
        } catch (error) {
          console.debug('Could not add cache for resource:', event.request);
        }
      });
      resolve(response);
    }).catch(error => {
      // We are offline, try to get resource from cache
      caches.match(event.request).then(response => {
        resolve(response);
      }).catch(ex => {
        reject(error);
      });
    });
  });
  event.respondWith(fetchPromise)
});