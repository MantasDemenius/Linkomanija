import React from 'react';
import FormError from './FormError';
export const maxQuestionLength = 360;
export const minQuestionLength = 10;
export const maxNicknameLength = 20;

export const whitespaceValidation = (text) => {
  return text.trim() === text && text.split(' ').length === 1;
};
export const passwordLengthValidation = (text) => {
  return text.length >= 8;
};
export const emailTypeValidation = (text) => {
  return text.match('^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+.[a-zA-Z0-9-.]+$') !== null;
};
export const isQuestionValid = (text) => {
  return minQuestionLength <= text.trim().length && text.trim().length <= maxQuestionLength;
};
export const isNicknameValidQF = (text) => {
  // Nickname validation in question form
  return text.trim().length === 0 || text.trim().length <= maxNicknameLength;
};
export const nicknameLengthValidation = (text) => {
  return text.length <= maxNicknameLength;
};
export const passwordContainValidation = (text) => {
  return text.match('[a-zA-Z]') && text.match('[0-9]');
};
export const nicknameValidation = (nickname) => {
  return nicknameLengthValidation(nickname) && whitespaceValidation(nickname);
};
export const passwordsMatchValidation = (textOne, textTwo) => {
  return textOne === textTwo;
};
export const emailValidation = (email) => {
  return whitespaceValidation(email) && emailTypeValidation(email);
};
export const passwordValidation = (password) => {
  return (
    whitespaceValidation(password) &&
    passwordLengthValidation(password) &&
    passwordContainValidation(password)
  );
};

export const emptyFieldValidation = (text) => {
  return text.trim().length !== 0;
};

export const enumChoiceValidation = (value, options) => {
  for (let option of Object.values(options)) {
    if (value === option) {
      return true;
    }
  }
  return false;
};

export const futureDateValidation = (date) => {
  return date > Date.now();
};

export const codeFieldValidation = (text) => {
  const trimLength = text.trim().length;
  return trimLength === 0 || (trimLength >= 3 && trimLength <= 30);
};

export const getError = (value, validator, message) => {
  if (!validator(value)) {
    return <FormError message={message} />;
  }
};
