import { TestBed } from '@angular/core/testing';

import { AdminLoginServiceService } from './admin-login-service.service';

describe('AdminLoginServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AdminLoginServiceService = TestBed.get(AdminLoginServiceService);
    expect(service).toBeTruthy();
  });
});
