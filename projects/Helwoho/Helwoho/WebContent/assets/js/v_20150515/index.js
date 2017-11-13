function supportsStorage() {
  try {
    return 'localStorage' in window && window['localStorage'] !== null;
  } catch (e) {
    return false;
  }
}

$(document).ready(function() {
  if (!supportsStorage) {
    alert("Browser version not supported...");
  }
});