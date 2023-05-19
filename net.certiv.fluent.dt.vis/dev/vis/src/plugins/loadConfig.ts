// Describes the json shape of the application config stored in /public/app-config.json
export interface Config {
  description: string;
  title: string;
  copyright: number;
  wsConnectUrl: string;
}

// Load the config from the static file '/public/app-config.json'
export function loadConfig(): Config {
  let config!: Config;
  const xhr = new XMLHttpRequest();
  xhr.open('GET', '/app-config.json', false);
  xhr.onerror = function () {
    alert('Config load operation failed!');
    // console.error('Load operation failed!');
  };
  xhr.onload = function () {
    if (xhr.status == 200) {
      // console.log(`Loaded ${xhr.response.length} bytes`);
      config = JSON.parse(xhr.responseText); /* as Config */
    } else {
      console.error(`Error ${xhr.status}: ${xhr.statusText}`); // e.g. 404: Not Found
    }
  };
  xhr.send();
  return config;
}
