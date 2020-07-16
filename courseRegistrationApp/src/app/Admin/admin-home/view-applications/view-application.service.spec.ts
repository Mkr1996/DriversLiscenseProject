import { TestBed } from '@angular/core/testing';

import { ViewApplicationService } from './view-application.service';

describe('ViewApplicationService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ViewApplicationService = TestBed.get(ViewApplicationService);
    expect(service).toBeTruthy();
  });
});
