import { TestBed } from '@angular/core/testing';

import { SubmitApplicationService } from './submit-application-service.service';

describe('SubmitApplicationServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: SubmitApplicationService = TestBed.get(SubmitApplicationService);
    expect(service).toBeTruthy();
  });
});
