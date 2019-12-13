const API_ROOT = process.env.REACT_APP_BE_BASE_URL;

async function sendRequest(path, method, data) {
  try {
    let req = new Request(API_ROOT + path, {
      method,
      body: JSON.stringify(data),
      headers: {
        'Content-Type': 'application/json'
      },
    });
    const response = await fetch(req);
    if (response.ok) {
      try {
        return { status: RESPONSE_STATUS.OK, data: await response.json() };
      } catch (d) {
        return { status: RESPONSE_STATUS.OK };
      }
    } else {
      return { status: RESPONSE_STATUS.BAD_RESPONSE };
    }
  } catch (e) {
    return { status: RESPONSE_STATUS.NO_CONNECTION };
  }
}

export async function putRequest(path, data) {
  return sendRequest(path, 'PUT', data);
}

export async function getRequest(path) {
  return sendRequest(path, 'GET');
}

export async function postRequest(path, data) {
  return sendRequest(path, 'POST', data);
}

export const RESPONSE_STATUS = {
  OK: 'OK',
  NO_CONNECTION: 'NO_CONNECTION',
  BAD_RESPONSE: 'BAD_RESPONSE',
};
