const svc = {
  getJson(url) {
    fetch(url)
      .then(resolve => resolve.json())
      .then(result => result.retVal)
      .catch(err => console.log(err));
  }
}